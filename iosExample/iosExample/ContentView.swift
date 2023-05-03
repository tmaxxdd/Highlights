//
//  ContentView.swift
//  iosExample
//
//  Created by Tomasz Kądziołka on 27/04/2023.
//

import SwiftUI
// import shared

struct ContentView: View {
    var body: some View {
        VStack {
            Highlights
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundColor(.accentColor)
            Text("Hello, world!")
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
