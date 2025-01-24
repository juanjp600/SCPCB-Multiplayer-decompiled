Function removemonitorinstances%()
    Local local0%
    For local0 = $00 To $01 Step $01
        freeentity(mon_i\Field0[local0])
        mon_i\Field0[local0] = $00
    Next
    mon_i\Field1[$00] = $00
    For local0 = $01 To $03 Step $01
        mon_i\Field1[local0] = $00
    Next
    For local0 = $05 To $0B Step $01
        mon_i\Field1[local0] = $00
    Next
    For local0 = $0C To $10 Step $01
        mon_i\Field1[local0] = $00
    Next
    Delete mon_i
    mon_i = Null
    Return $00
End Function
