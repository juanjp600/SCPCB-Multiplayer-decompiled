Function removenpcinstances%()
    Local local0%
    For local0 = $00 To $20 Step $01
        freeentity(n_i\Field0[local0])
        n_i\Field0[local0] = $00
    Next
    For local0 = $00 To $12 Step $01
        n_i\Field1[local0] = $00
    Next
    Delete n_i
    n_i = Null
    Return $00
End Function
