Function se_array_addelements%(arg0.se_array, arg1%, arg2%)
    Local local0%
    Local local1.se_value
    Local local2%
    If (arg2 = $00) Then
        arg2 = $01
    EndIf
    For local0 = $01 To arg1 Step $01
        local1 = (New se_value)
        se_setvalue(local1, "0", arg2)
        local2 = (arg0\Field1 Shl $02)
        arg0\Field1 = (arg0\Field1 + $01)
        resizebank(arg0\Field2, (arg0\Field1 Shl $02))
        pokeint(arg0\Field2, local2, (Handle local1))
    Next
    Return $00
End Function
