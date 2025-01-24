Function removeleverinstances%()
    Local local0%
    For local0 = $00 To $01 Step $01
        freeentity(lvr_i\Field0[local0])
        lvr_i\Field0[local0] = $00
    Next
    Delete lvr_i
    lvr_i = Null
    Return $00
End Function
