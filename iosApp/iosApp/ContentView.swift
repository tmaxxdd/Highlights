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
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundColor(.accentColor)
            Text("Hello, world!")
            ComposableView().ignoresSafeArea(.keyboard)
            
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
