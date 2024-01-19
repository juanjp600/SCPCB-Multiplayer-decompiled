Function steambrowser_find.steambrowser(arg0%, arg1%)
    Local local0.steambrowser
    local0 = Null
    If (arg0 <> $00) Then
        For local0 = Each steambrowser
            If (local0\Field0 = arg0) Then
                Return local0
            EndIf
        Next
    EndIf
    If (arg1 <> $00) Then
        For local0 = Each steambrowser
            If (((local0\Field1 <> $00) And (bs_long_compare(arg1, local0\Field1) = $00)) <> 0) Then
                Return local0
            EndIf
        Next
    EndIf
    Return Null
    Return Null
End Function
