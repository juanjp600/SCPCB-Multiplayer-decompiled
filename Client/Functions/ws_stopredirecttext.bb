Function ws_stopredirecttext%(arg0$)
    Local local0%
    Local local1.redirecttext
    local0 = $00
    For local1 = Each redirecttext
        If (local1\Field1 = arg0) Then
            Delete local1
            local0 = $01
        EndIf
    Next
    Return local0
    Return $00
End Function
