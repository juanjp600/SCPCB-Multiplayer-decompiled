Function se_compileparenthesis%(arg0.se_node)
    Local local0.se_node
    Local local1.se_vf_value
    Local local2%
    Local local3.se_vf_value
    Local local4.se_vf_value
    Local local5.se_vf_value
    Local local6.se_vf_funcptr
    local0 = arg0\Field6
    If (local0\Field0 <> Null) Then
        If (local0\Field0\Field0 = $04) Then
            arg0 = arg0\Field4[$01]
            If (arg0\Field0\Field0 <> $06) Then
                Repeat
                    local1 = se_compilenode(arg0)
                    If (local1 = Null) Then
                        local1 = se_poptemp()
                    EndIf
                    local2 = (local2 + $01)
                    se_vf_createinst($1B, local1, Null, Null)
                    arg0 = se_nextnode(arg0)
                    If (arg0\Field0\Field0 = $06) Then
                        Exit
                    Else
                        arg0 = arg0\Field8
                    EndIf
                Forever
            EndIf
            local3 = (New se_vf_value)
            local4 = se_vf_createbasic($01, (Str local2))
            local5 = se_pushtemp()
            local6 = se_getfunction(local0\Field0\Field1)
            If (local6 <> Null) Then
                local3\Field0 = $09
                local3\Field2 = local6\Field1
                se_vf_createinst($1C, local3, local4, local5)
                If (((mainfunction And (mainfunctionerror = $00)) And (mainfunctionerrorblock = $00)) <> 0) Then
                    se_warn(local0\Field0, "execute functions in main block won't work")
                EndIf
            Else
                local3\Field0 = $03
                local3\Field1 = local0\Field0\Field1
                se_vf_createinst($1D, local3, local4, local5)
                If (se_isvalidfunction(lower(local3\Field1)) = $00) Then
                    se_warn(local0\Field0, "undefined function")
                EndIf
                If (((mainfunction And (mainfunctionerror = $00)) And (mainfunctionerrorblock = $00)) <> 0) Then
                    se_warn(local0\Field0, "execute functions in main block won't work")
                EndIf
            EndIf
        Else
            se_compilenode(arg0\Field4[$01])
            arg0 = se_nextnode(arg0\Field4[$01])
        EndIf
    Else
        se_compilenode(arg0\Field4[$01])
        arg0 = se_nextnode(arg0\Field4[$01])
    EndIf
    arg0 = arg0\Field8
    If (arg0 <> Null) Then
        se_compilenode(arg0)
    EndIf
    Return $00
End Function
