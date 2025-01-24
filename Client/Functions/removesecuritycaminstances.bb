Function removesecuritycaminstances%()
    Local local0%
    For local0 = $00 To $01 Step $01
        freeentity(sc_i\Field0[local0])
        sc_i\Field0[local0] = $00
    Next
    sc_i\Field2 = $00
    For local0 = $00 To $01 Step $01
        sc_i\Field1[local0] = $00
    Next
    Delete sc_i
    sc_i = Null
    Return $00
End Function
