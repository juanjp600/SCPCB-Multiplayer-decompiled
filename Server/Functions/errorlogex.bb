Function errorlogex$()
    Local local0$
    Local local1.errs
    local0 = errorlog()
    If (local0 = "") Then
        For local1 = Each errs
            local0 = local1\Field0
            Delete local1
            Exit
        Next
    EndIf
    Return local0
    Return ""
End Function
