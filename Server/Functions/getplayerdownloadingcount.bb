Function getplayerdownloadingcount%(arg0%)
    Local local0%
    Local local1.querys
    local0 = $00
    For local1 = Each querys
        If (local1\Field3 = arg0) Then
            local0 = (local0 + $01)
        EndIf
    Next
    Return local0
    Return $00
End Function
