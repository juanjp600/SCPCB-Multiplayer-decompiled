Function se_arraysyntax%(arg0.se_node)
    Local local0.se_node
    Local local1%
    Local local2%
    local0 = arg0\Field6
    If (local0\Field0 <> Null) Then
        If (local0\Field0\Field0 = $04) Then
            local1 = $01
        ElseIf (local0\Field1 = $01) Then
            If (arg0\Field7 <> Null) Then
                If (arg0\Field7\Field1 = $06) Then
                    local1 = $01
                EndIf
            EndIf
        EndIf
    EndIf
    If (arg0\Field4[$01] = Null) Then
        se_error_eol(arg0\Field0)
        Return $00
    Else
        arg0 = arg0\Field4[$01]
    EndIf
    If (local1 <> 0) Then
        If (arg0\Field0\Field0 = $0B) Then
            se_error_unexpected(arg0\Field0)
            Return $00
        Else
            se_nodesyntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
            arg0 = se_nextnode(arg0)
            If (arg0\Field0\Field0 <> $0B) Then
                se_error_expecting(arg0\Field0, "']'")
                Return $00
            EndIf
        EndIf
    Else
        While (arg0\Field0\Field0 <> $0B)
            se_nodesyntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
            arg0 = se_nextnode(arg0)
            If (arg0\Field0\Field0 = $08) Then
                arg0 = arg0\Field8
            ElseIf (arg0\Field0\Field0 <> $0B) Then
                se_error_unexpected(arg0\Field0)
                Return $00
            EndIf
        Wend
    EndIf
    If (arg0\Field8 <> Null) Then
        If (local1 <> 0) Then
            se_nodesyntax(arg0\Field8)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Else
            se_error_unexpected(arg0\Field8\Field0)
            Return $00
        EndIf
    EndIf
    Return $00
End Function
