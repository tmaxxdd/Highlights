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
       IOSClientScreenKt.MainViewController()
   }

   func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
 }

struct ContentView: View {
    var body: some View {
      ComposeView().ignoresSafeArea(.keyboard) // Compose has own keyboard handler
//         Text("\(Highlights.companion.getText())")
    }
}
