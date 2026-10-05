Function se_readarg.se_value(arg0%, arg1%)
    Local local0.se_value
    Local local1%
    Local local2%
    If (se_canread(arg0, $01) = $00) Then
        Return Null
    EndIf
    local1 = readbyte(arg0)
    Select local1
        Case $01
            If (se_canread(arg0, $04) = $00) Then
                Return Null
            EndIf
            local0 = (New se_value)
            local0\Field0 = local1
            local0\Field2 = readint(arg0)
        Case $02
            If (se_canread(arg0, $04) = $00) Then
                Return Null
            EndIf
            local0 = (New se_value)
            local0\Field0 = local1
            local0\Field3 = readfloat(arg0)
        Case $03
            local0 = (New se_value)
            local0\Field0 = local1
            local0\Field4 = se_readsafestring(arg0)
            If (arg1 = $1D) Then
                local0\Field9 = se_getfunctionid(local0\Field4)
            EndIf
        Case $04
            If (se_canread(arg0, $04) = $00) Then
                Return Null
            EndIf
            local0 = (New se_value)
            local0\Field0 = local1
            local0\Field2 = readint(arg0)
            If (((local0\Field2 < $00) Or (local0\Field2 >= se_loadtransientlimit(se_loadinstindex))) <> 0) Then
                se_loadinvalid = $01
                Return Null
            EndIf
        Case $08
            If (se_canread(arg0, $04) = $00) Then
                Return Null
            EndIf
            local2 = readint(arg0)
            If (((local2 < $00) Or (local2 > se_vf_label_n)) <> 0) Then
                se_loadinvalid = $01
                Return Null
            EndIf
            local0 = se_vf_a_label(local2)
        Case $09
            If (se_canread(arg0, $04) = $00) Then
                Return Null
            EndIf
            local0 = (New se_value)
            local0\Field0 = local1
            local2 = readint(arg0)
            If (((local2 < $00) Or (local2 > se_vf_func_ptr_n)) <> 0) Then
                se_loadinvalid = $01
                Return Null
            EndIf
            local0\Field8 = se_vf_a_func_ptr(local2)
        Case $0A
            If (se_canread(arg0, $04) = $00) Then
                Return Null
            EndIf
            local2 = readint(arg0)
            If (((local2 < $00) Or (local2 > se_vf_static_n)) <> 0) Then
                se_loadinvalid = $01
                Return Null
            EndIf
            local0 = se_vf_a_static(local2)
        Default
            se_loadinvalid = $01
    End Select
    Return local0
    Return Null
End Function
