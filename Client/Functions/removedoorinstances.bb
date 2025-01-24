Function removedoorinstances%()
    Local local0%
    For local0 = $00 To $08 Step $01
        freeentity(d_i\Field0[local0])
        d_i\Field0[local0] = $00
    Next
    For local0 = $00 To $03 Step $01
        freeentity(d_i\Field1[local0])
        d_i\Field1[local0] = $00
    Next
    freeentity(d_i\Field4)
    d_i\Field4 = $00
    For local0 = $00 To $04 Step $01
        freeentity(d_i\Field2[local0])
        d_i\Field2[local0] = $00
    Next
    For local0 = $01 To $02 Step $01
        d_i\Field5[local0] = $00
    Next
    For local0 = $00 To $03 Step $01
        d_i\Field3[local0] = $00
    Next
    Delete d_i
    d_i = Null
    Return $00
End Function
