//
//  ContentView.swift
//  iosApp
//
//  Created by Tomasz Kądziołka on 01/05/2023.
//

import SwiftUI
import shared

struct ComposableView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        IOSClientScreenKt.CodeTextViewUiViewControllerDefault(code: "class Java extends {/n/n}")
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    @Environment(\.colorScheme) var colorScheme
    @State private var themeSelection = 0
    @State private var languageSelection = 0
    
    
    var body: some View {
        VStack {
            Text("Highlights")
            Divider()
            ComposableView().ignoresSafeArea(.keyboard)
            Picker(selection: $themeSelection, label: Text("Select theme")) {
                let themes = SyntaxThemes.shared.themes.keys.map { $0.description }
                ForEach(themes, id: \.self) {
                    Text("\($0)")
                }
            }
            
            Picker(selection: $languageSelection, label: Text("Select Language")) {
                let languages = SyntaxLanguage.companion.getNames()
                ForEach(languages, id: \.self) {
                    Text("\($0)")
                }
            }
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
