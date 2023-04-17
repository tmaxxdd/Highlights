//
//  ContentView.swift
//  iosExample
//
//  Created by Tomasz Kądziołka on 16/04/2023.
//

import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundColor(.accentColor)
            Text("\(Highlights.Companion().fromBuilder(builder: Highlights.Builder.init(code: "// abcd", language: SyntaxLanguage.cpp, theme: SyntaxTheme.init(code: 0, keyword: 0, string: 0, literal: 0, comment: 0, metadata: 0, multilineComment: 0, punctuation: 0, mark: 0), emphasisLocations: [])).getHighlights().description)")
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
