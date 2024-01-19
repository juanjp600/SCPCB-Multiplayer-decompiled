Function updatedeadbodies%()
    Local local0.corpses
    For local0 = Each corpses
        local0\Field10 = (millisecs() > (local0\Field6 - $1CCF0))
        If (local0\Field6 < millisecs()) Then
            local0\Field9 = $01
            If (0.0 > local0\Field8) Then
                Delete local0
            Else
                local0\Field3 = (local0\Field3 - (0.001 * fpsfactor))
                local0\Field8 = (local0\Field8 - fpsfactor)
            EndIf
        EndIf
    Next
    Return $00
End Function
