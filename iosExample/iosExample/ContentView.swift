//
//  ContentView.swift
//  iosExample
//
//  Created by Tomasz Kądziołka on 16/04/2023.
//

import SwiftUI
import shared

 struct ComposeView: UIViewControllerRepresentable {
   func makeUIViewController(context: Context) -> UIViewController {
       IOSClientScreenKt.CodeTextViewUiViewController(
        code: "abcd",
        language: SyntaxLanguage.values().index(of: 0),
        theme: SyntaxThemes.shared.monokai
       )
   }

   func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
 }

struct ContentView: View {
    var body: some View {
      ComposeView().ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}
