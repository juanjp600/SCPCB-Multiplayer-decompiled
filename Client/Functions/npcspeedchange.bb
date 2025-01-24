Function npcspeedchange%(arg0.npcs)
    Select arg0\Field4
        Case $07,$06,$05,$02,$0B
            Select selecteddifficulty\Field4
                Case $01
                    arg0\Field23 = (arg0\Field23 * 1.1)
                Case $02
                    arg0\Field23 = (arg0\Field23 * 1.2)
                Case $03
                    arg0\Field23 = (arg0\Field23 * 1.3)
            End Select
    End Select
    Return $00
End Function
