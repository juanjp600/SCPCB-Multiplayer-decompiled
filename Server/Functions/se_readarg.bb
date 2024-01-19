Function se_readarg.se_value(arg0%, arg1%)
    Local local0.se_value
    Local local1%
    local1 = readbyte(arg0)
    Select local1
        Case $01
            local0 = (New se_value)
            local0\Field0 = local1
            local0\Field1 = readint(arg0)
        Case $02
            local0 = (New se_value)
            local0\Field0 = local1
            local0\Field2 = readfloat(arg0)
        Case $03
            local0 = (New se_value)
            local0\Field0 = local1
            local0\Field3 = readstring(arg0)
            If (arg1 = $1D) Then
                local0\Field8 = se_getfunctionid(local0\Field3)
            EndIf
        Case $04
            local0 = (New se_value)
            local0\Field0 = local1
            local0\Field1 = readint(arg0)
        Case $08
            local0 = se_vf_a_label(readint(arg0))
        Case $09
            local0 = (New se_value)
            local0\Field0 = local1
            local0\Field7 = se_vf_a_func_ptr(readint(arg0))
        Case $0A
            local0 = se_vf_a_static(readint(arg0))
    End Select
    Return local0
    Return Null
End Function
