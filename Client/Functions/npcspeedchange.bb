Function npcspeedchange%(arg0.npcs)
    Local local0#
    local0 = 1.0
    Select selecteddifficulty\Field5
        Case $01
            local0 = 1.2
        Case $02
            local0 = 1.3
    End Select
    Select arg0\Field5
        Case $01,$02,$09,$0A,$0F,$08
            arg0\Field21 = (arg0\Field21 * local0)
        Case $15,$0B
            arg0\Field21 = (arg0\Field21 * local0)
    End Select
    Return $00
End Function
