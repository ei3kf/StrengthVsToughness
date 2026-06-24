import SwiftUI

@main
struct StrengthVsToughnessApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

struct ContentView: View {

    @State private var strength = 5
    @State private var toughness = 5

    var woundRoll: String {
        if strength >= toughness * 2 {
            return "2+"
        } else if strength > toughness {
            return "3+"
        } else if strength == toughness {
            return "4+"
        } else if strength * 2 <= toughness {
            return "6+"
        } else {
            return "5+"
        }
    }

    var body: some View {
        VStack(spacing: 30) {

            Text("Strength vs Toughness")
                .font(.largeTitle)
                .bold()

            VStack {
                Text("Strength")
                    .font(.headline)

                Picker("Strength", selection: $strength) {
                    ForEach(1...30, id: \.self) {
                        Text("\($0)")
                    }
                }
                .pickerStyle(.wheel)
                .frame(height: 120)
            }

            VStack {
                Text("Toughness")
                    .font(.headline)

                Picker("Toughness", selection: $toughness) {
                    ForEach(1...30, id: \.self) {
                        Text("\($0)")
                    }
                }
                .pickerStyle(.wheel)
                .frame(height: 120)
            }

            VStack(spacing: 10) {
                Text("Roll to Wound")
                    .font(.title2)

                Text(woundRoll)
                    .font(.system(size: 120, weight: .bold))
                    .foregroundStyle(.primary)
            }

            Spacer()
        }
        .padding()
    }
}
