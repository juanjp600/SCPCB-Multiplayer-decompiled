Function initadjacentroomdoors%(arg0.rooms)
    Local local0%
    Local local1%
    Local local2%
    local0 = arg0\Field31
    For local1 = $00 To $03 Step $01
        If (arg0\Field35[local1] <> Null) Then
            For local2 = $01 To $13 Step $01
                If (arg0\Field30[local2] = Null) Then
                    local0 = local2
                    arg0\Field30[local2] = arg0\Field35[local1]
                    Exit
                EndIf
            Next
        EndIf
    Next
    arg0\Field31 = local0
    Return $00
End Function
