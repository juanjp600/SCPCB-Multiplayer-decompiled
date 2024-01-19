Function setrandomseed$()
    Local local0$
    Local local2%
    Local local3%
    If (rand($0F, $01) = $01) Then
        Select rand($0E, $01)
            Case $01
                local0 = "NIL"
            Case $02
                local0 = "NO"
            Case $03
                local0 = "d9341"
            Case $04
                local0 = "5CP_I73"
            Case $05
                local0 = "DONTBLINK"
            Case $06
                local0 = "CRUNCH"
            Case $07
                local0 = "die"
            Case $08
                local0 = "HTAED"
            Case $09
                local0 = "rustledjim"
            Case $0A
                local0 = "larry"
            Case $0B
                local0 = "JORGE"
            Case $0C
                local0 = "dirtymetal"
            Case $0D
                local0 = "whatpumpkin"
            Case $0E
                local0 = "14542015"
        End Select
    Else
        local2 = rand($01, $0D)
        For local3 = $01 To local2 Step $01
            If (rand($03, $01) = $01) Then
                Select rand($0C, $01)
                    Case $01
                        local0 = "deeznuts"
                    Case $02
                        local0 = "7kyr06"
                    Case $03
                        local0 = "36139326"
                    Case $04
                        local0 = "catsarecute"
                    Case $05
                        local0 = "6660666"
                    Case $06
                        local0 = "173309319"
                    Case $07
                        local0 = "Ohmygandhi"
                    Case $08
                        local0 = "16535651"
                    Case $09
                        local0 = "Oi61sfbn"
                    Case $0A
                        local0 = "612672311"
                    Case $0B
                        local0 = "cum"
                    Case $0C
                        local0 = "whiskey"
                End Select
            Else
                Select rand($0E, $01)
                    Case $01
                        local0 = "NIL"
                    Case $02
                        local0 = "NO"
                    Case $03
                        local0 = "d9341"
                    Case $04
                        local0 = "5CP_I73"
                    Case $05
                        local0 = "DONTBLINK"
                    Case $06
                        local0 = "CRUNCH"
                    Case $07
                        local0 = "die"
                    Case $08
                        local0 = "HTAED"
                    Case $09
                        local0 = "rustledjim"
                    Case $0A
                        local0 = "larry"
                    Case $0B
                        local0 = "JORGE"
                    Case $0C
                        local0 = "dirtymetal"
                    Case $0D
                        local0 = "whatpumpkin"
                    Case $0E
                        local0 = "14542015"
                End Select
            EndIf
        Next
    EndIf
    Return local0
    Return ""
End Function
