Function createquickclue%(arg0$)
    Local local0%
    Local local1.clues
    For local0 = $00 To $1F Step $01
        If (clues[local0] = $FFFFFFFF) Then
            local1 = (New clues)
            local1\Field0 = arg0
            clues[local0] = (Handle local1)
            Exit
        EndIf
    Next
    Return local0
    Return $00
End Function
