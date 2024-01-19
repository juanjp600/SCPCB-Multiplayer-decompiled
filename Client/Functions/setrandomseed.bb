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
        local2 = rand($04, $08)
        For local3 = $01 To local2 Step $01
            If (rand($03, $01) = $01) Then
                local0 = (local0 + (Str rand($00, $09)))
            Else
                local0 = (local0 + chr(rand($61, $7A)))
            EndIf
        Next
    EndIf
    Return local0
    Return ""
End Function
