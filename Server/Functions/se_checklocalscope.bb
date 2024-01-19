Function se_checklocalscope%(arg0$)
    Local local0.se_localdef
    Local local1.se_staticdef
    local0 = se_function_def\Field1
    While (local0 <> Null)
        If (local0\Field1 = arg0) Then
            Return $01
        EndIf
        local0 = local0\Field2
    Wend
    local1 = se_function_def\Field3
    While (local1 <> Null)
        If (local1\Field1 = arg0) Then
            Return $01
        EndIf
        local1 = local1\Field2
    Wend
    Return $00
End Function
