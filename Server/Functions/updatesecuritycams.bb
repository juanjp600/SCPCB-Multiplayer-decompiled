Function updatesecuritycams%()
    Local local0.securitycams
    For local0 = Each securitycams
        If (local0\Field8 <> $00) Then
            hideentity(local0\Field8)
        EndIf
        If (local0\Field4 <> $00) Then
            showentity(local0\Field4)
        EndIf
    Next
    Return $00
End Function
