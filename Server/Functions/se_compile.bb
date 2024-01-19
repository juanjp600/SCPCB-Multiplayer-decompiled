Function se_compile%(arg0$)
    Local local0.se_block
    se_parselines(arg0)
    If (se_error <> 0) Then
        Return $00
    EndIf
    se_parsetokens()
    If (se_error <> 0) Then
        Return $00
    EndIf
    se_parsechunks()
    If (se_error <> 0) Then
        Return $00
    EndIf
    se_parseblocks(Null)
    If (se_error <> 0) Then
        Return $00
    EndIf
    se_parsedefinitions()
    If (se_error <> 0) Then
        Return $00
    EndIf
    se_checksyntax()
    If (se_error <> 0) Then
        Return $00
    EndIf
    local0 = se_root_block\Field7
    While (local0 <> Null)
        If (local0\Field0 = $04) Then
            se_compileblock(local0)
        EndIf
        local0 = local0\Field6
    Wend
    local0 = se_root_block\Field7
    se_function_def = se_main_function
    se_function_def\Field0\Field2 = (Last se_vf_inst)
    While (local0 <> Null)
        If (local0\Field0 <> $04) Then
            mainfunction = $01
            se_compileblock(local0)
            mainfunction = $00
        EndIf
        local0 = local0\Field6
    Wend
    If (mainfunctionerror <> 0) Then
        se_error = $01
        mainfunctionerror = $00
        Return $00
    EndIf
    mainfunctionerror = $00
    mainfunctionerrorblock = $00
    se_vf_createinst($1F, Null, Null, Null)
    If (se_function_def\Field0\Field2 = Null) Then
        se_function_def\Field0\Field2 = (First se_vf_inst)
    Else
        se_function_def\Field0\Field2 = (After se_function_def\Field0\Field2)
    EndIf
    se_function_def\Field0\Field3 = (Last se_vf_inst)
    For se_function_def = Each se_functiondef
        If (se_function_def <> se_main_function) Then
            se_function_def\Field0\Field3 = (After se_function_def\Field0\Field3)
        EndIf
    Next
    se_indextemps()
    Return $00
End Function
