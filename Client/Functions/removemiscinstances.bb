Function removemiscinstances%()
    Local local0%
    For local0 = $00 To $06 Step $01
        freeentity(misc_i\Field0[local0])
        misc_i\Field0[local0] = $00
    Next
    freeentity(misc_i\Field1)
    misc_i\Field1 = $00
    For local0 = $00 To $01 Step $01
        misc_i\Field2[local0] = $00
    Next
    misc_i\Field3 = $00
    Delete misc_i
    misc_i = Null
    Return $00
End Function
