Function se_compilearray%(arg0.se_node)
    Local local0.se_node
    Local local1%
    Local local2%
    Local local3.se_vf_value
    Local local4.se_vf_value
    Local local5.se_vf_value
    Local local6%
    local0 = arg0\Field6
    If (local0\Field0 <> Null) Then
        If (local0\Field0\Field0 = $04) Then
            local1 = $01
        ElseIf (local0\Field1 = $01) Then
            If (arg0\Field7 <> Null) Then
                If (arg0\Field7\Field1 = $06) Then
                    local1 = $01
                    local2 = $01
                    runtimeerror("")
                EndIf
            EndIf
        EndIf
    EndIf
    arg0 = arg0\Field4[$01]
    If (local1 <> 0) Then
        local4 = se_compilenode(arg0)
        If (local4 = Null) Then
            local4 = se_poptemp()
        EndIf
        If (local2 = $00) Then
            local3 = se_getvariable(local0\Field0\Field1)
        Else
            local3 = se_poptemp()
        EndIf
        local5 = se_pushtemp()
        se_vf_createinst($24, local3, local4, local5)
        arg0 = se_nextnode(arg0)
        arg0 = arg0\Field8
        If (arg0 <> Null) Then
            se_compilenode(arg0)
        EndIf
    Else
        While (arg0\Field0\Field0 <> $0B)
            local3 = se_compilenode(arg0)
            If (local3 = Null) Then
                local3 = se_poptemp()
            EndIf
            se_vf_createinst($1B, local3, Null, Null)
            local6 = (local6 + $01)
            arg0 = se_nextnode(arg0)
            If (arg0\Field0\Field0 = $08) Then
                arg0 = arg0\Field8
            EndIf
        Wend
        local3 = se_vf_createbasic($01, (Str local6))
        local4 = se_pushtemp()
        se_vf_createinst($23, local3, local4, Null)
    EndIf
    Return $00
End Function
