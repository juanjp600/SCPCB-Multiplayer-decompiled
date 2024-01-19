Function updatedeadbodies%()
    Local local0.p_obj
    For local0 = Each p_obj
        If ((hidedistance * 1.5) <= entitydistance(collider, local0\Field2)) Then
            hideentity(local0\Field2)
        Else
            showentity(local0\Field2)
        EndIf
        If (local0\Field3 < millisecs()) Then
            If (0.0 > local0\Field4) Then
                freeentity(local0\Field2)
                Delete local0
            Else
                translateentity(local0\Field2, 0.0, (-0.001 * fpsfactor), 0.0, $00)
                local0\Field4 = (local0\Field4 - fpsfactor)
            EndIf
        EndIf
    Next
    Return $00
End Function
