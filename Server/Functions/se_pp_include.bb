Function se_pp_include%(arg0$, arg1$)
    Local local0%
    Local local1$
    Local local2%
    local0 = len(arg1)
    local2 = local0
    While (local2 >= $01)
        If (((mid(arg1, local2, $01) = "\") Or (mid(arg1, local2, $01) = "/")) <> 0) Then
            local1 = left(arg1, local2)
            se_parselines((local1 + arg0))
            Return $00
        EndIf
        local2 = (local2 + $FFFFFFFF)
    Wend
    se_parselines(arg0)
    Return $00
End Function
