Function updatedebug3d%()
    Local local0.debugger
    For local0 = Each debugger
        If (local0\Field2 > $00) Then
            local0\Field2 = (Int ((Float local0\Field2) - fpsfactor))
        Else
            If (local0\Field0 <> $00) Then
                freeentity(local0\Field0)
                local0\Field0 = $00
            EndIf
            Delete local0
        EndIf
    Next
    Return $00
End Function
