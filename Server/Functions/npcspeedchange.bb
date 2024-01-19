Function npcspeedchange%(arg0.npcs)
    Select arg0\Field5
        Case $01,$02,$09,$0A,$0F,$08
            Select selecteddifficulty\Field5
                Case $01
                    arg0\Field21 = (arg0\Field21 * 1.1)
                Case $02
                    arg0\Field21 = (arg0\Field21 * 1.2)
            End Select
    End Select
    Return $00
End Function
