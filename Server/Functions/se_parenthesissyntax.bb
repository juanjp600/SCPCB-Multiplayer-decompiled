Function se_parenthesissyntax%(arg0.se_node)
    Local local0.se_node
    Local local1%
    local0 = arg0\Field6
    If (local0\Field0 <> Null) Then
        If (local0\Field0\Field0 = $04) Then
            If (se_checkconstant(local0\Field0\Field1) <> 0) Then
                se_error(local0\Field0, (("constant '" + local0\Field0\Field1) + "' cannot be invoked "), $01)
                Return $00
            EndIf
            local1 = $01
        ElseIf (arg0\Field7 <> Null) Then
            se_error_unexpected(arg0\Field0)
            Return $00
        EndIf
    EndIf
    If (arg0\Field4[$01] = Null) Then
        se_error_eol(arg0\Field0)
        Return $00
    Else
        arg0 = arg0\Field4[$01]
    EndIf
    If (local1 = $00) Then
        se_nodesyntax(arg0)
        arg0 = se_nextnode(arg0)
        If (arg0\Field0\Field0 <> $06) Then
            se_error_unexpected(arg0\Field0)
            Return $00
        EndIf
    ElseIf (arg0\Field0\Field0 <> $06) Then
        Repeat
            se_nodesyntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
            arg0 = se_nextnode(arg0)
            If (arg0\Field0\Field0 = $06) Then
                Exit
            ElseIf (arg0\Field0\Field0 = $08) Then
                arg0 = arg0\Field8
            Else
                se_error_unexpected(arg0\Field0)
                Return $00
            EndIf
        Forever
    EndIf
    If (arg0\Field8 <> Null) Then
        se_nodesyntax(arg0\Field8)
        If (se_error <> 0) Then
            Return $00
        EndIf
    EndIf
    Return $00
End Function
