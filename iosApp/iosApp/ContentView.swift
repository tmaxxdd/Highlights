//
//  ContentView.swift
//  iosApp
//
//  Created by Tomasz Kądziołka on 01/05/2023.
//

import SwiftUI
import shared

struct CodeTextView: UIViewControllerRepresentable {
    @Binding private var highlights: Highlights
    
    init(newHighlights: Binding<Highlights>) {
        self._highlights = newHighlights
    }
    
    func makeUIViewController(context: Context) -> UIViewController {
        return UIViewController()
    }
    
    func updateUIViewController(_ wrapper: UIViewController, context: Context) {
        let kotlinController = IOSClientScreenKt.CodeTextViewUiViewController(highlights: highlights)
        // Cleanup
        kotlinController.removeFromParent()
        kotlinController.view.removeFromSuperview()
        // Update view
        wrapper.addChild(kotlinController)
        wrapper.view.addSubview(kotlinController.view)
        // Match with frame
        kotlinController.view.frame = wrapper.view.frame
        kotlinController.didMove(toParent: wrapper)
    }
}

struct ContentView: View {
    @State var highlights = Highlights.companion.default()
    private let themes = SyntaxThemes.shared.themes(darkMode: false)
    private let languages = SyntaxLanguage.companion.getNames()
    
    init() {
        highlights.setCode(code:
            """
            class Main {
                public static void main(String[] args) {
                    int abcd = 100;
                }
            }
            """
        )
    }
    
    var body: some View {
        VStack {
            Text("Highlights")
            Divider()
            CodeTextView(newHighlights: $highlights)
                .ignoresSafeArea(.keyboard)
                .padding()
            Divider()
            DropdownMenu(
                values: getThemeNames(themes: themes),
                defaultSelection: getThemeNames(themes: themes)
                    .firstIndex(of: highlights.getTheme().description()) ?? 0
            ) { selection in
                $highlights.wrappedValue = highlights
                    .getBuilder()
                    .theme(theme: themes[selection]!)
                    .build()
            }
            
            DropdownMenu(
                values: languages,
                defaultSelection:
                    SyntaxLanguage.companion.getNames()
                    .firstIndex(of: highlights.getLanguage().description()) ?? 0
            ) { selection in
                let newLanguage = SyntaxLanguage.companion.getByName(name: selection)
                $highlights.wrappedValue = highlights
                    .getBuilder()
                    .language(language: newLanguage!)
                    .build()
            }
        }
    }
    
    func getThemeNames(themes: Dictionary<String, SyntaxTheme>) -> Array<String> {
        return themes.keys.map { $0.description }.sorted()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}