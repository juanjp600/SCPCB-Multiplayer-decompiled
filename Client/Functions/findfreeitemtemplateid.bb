Function findfreeitemtemplateid%()
    Local local0%
    Local local1%
    Local local2.itemtemplates
    local0 = $01
    Repeat
        local1 = $00
        For local2 = Each itemtemplates
            If (local2\Field0 = local0) Then
                local1 = $01
                Exit
            EndIf
        Next
        If (local1 = $00) Then
            Return local0
        EndIf
        local0 = (local0 + $01)
    Forever
    Return $00
End Function
