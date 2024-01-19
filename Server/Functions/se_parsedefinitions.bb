Function se_parsedefinitions%()
    Local local0.se_block
    Local local1.se_globaldef
    Local local2.se_publicdef
    Local local3.se_functiondef
    Local local4.se_localdef
    Local local5.se_staticdef
    local0 = se_root_block\Field7
    se_main_function = se_definefunction("_main", Null)
    While (local0 <> Null)
        If (local0\Field4 = se_root_block) Then
            se_function_def = se_main_function
        EndIf
        se_parsedefinition(local0)
        If (se_error <> 0) Then
            Return $00
        EndIf
        local0 = (After local0)
    Wend
    For local1 = Each se_globaldef
        If ((se_checkconstant(local1\Field1) Or se_checkfunction(local1\Field1)) <> 0) Then
            se_error(local1\Field2, (("duplicate identifier '" + local1\Field1) + "'"), $01)
            Return $00
        EndIf
    Next
    For local2 = Each se_publicdef
        If ((se_checkconstant(local2\Field1) Or se_checkfunction(local2\Field1)) <> 0) Then
            se_error(local2\Field2, (("duplicate identifier '" + local2\Field1) + "'"), $01)
            Return $00
        EndIf
    Next
    For local3 = Each se_functiondef
        se_checkconstant(local3\Field0\Field0)
        local4 = local3\Field1
        While (local4 <> Null)
            If ((se_checkconstant(local4\Field1) Or se_checkfunction(local4\Field1)) <> 0) Then
                se_error(local4\Field3, (("duplicate identifier '" + local4\Field1) + "'"), $01)
                Return $00
            EndIf
            If (se_checkglobalscope(local4\Field1) <> 0) Then
                se_warn(local4\Field3, (("name conflict with global/public variable '" + local4\Field1) + "'"))
            EndIf
            local4 = local4\Field2
        Wend
        local5 = local3\Field3
        While (local5 <> Null)
            If ((se_checkconstant(local5\Field1) Or se_checkfunction(local5\Field1)) <> 0) Then
                se_error(local5\Field3, (("duplicate identifier '" + local5\Field1) + "'"), $01)
                Return $00
            EndIf
            If (se_checkglobalscope(local5\Field1) <> 0) Then
                se_warn(local5\Field3, (("name conflict with global/public variable '" + local5\Field1) + "'"))
            EndIf
            local5 = local5\Field2
        Wend
    Next
    Return $00
End Function
