Function se_nodesyntax%(arg0.se_node)
    Local local0.se_token
    local0 = arg0\Field0
    If (local0\Field0 <= $03) Then
        If (arg0\Field4[$01] <> Null) Then
            se_error_unexpected(arg0\Field4[$01]\Field0)
            Return $00
        EndIf
    ElseIf (local0\Field0 = $04) Then
        If (arg0\Field4[$01] <> Null) Then
            se_nodesyntax(arg0\Field4[$01])
            If (se_error <> 0) Then
                Return $00
            EndIf
        EndIf
    ElseIf (local0\Field0 = $07) Then
        se_operatorsyntax(arg0)
        If (se_error <> 0) Then
            Return $00
        EndIf
    ElseIf (local0\Field0 = $05) Then
        se_parenthesissyntax(arg0)
        If (se_error <> 0) Then
            Return $00
        EndIf
    ElseIf (local0\Field0 = $0A) Then
        se_arraysyntax(arg0)
        If (se_error <> 0) Then
            Return $00
        EndIf
    Else
        se_error_unexpected(local0)
        Return $00
    EndIf
    Return $00
End Function
