Function updateachievementmsg%()
    Local local0.achievementmsg
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    local2 = (Int (351.0 * menuscale))
    local3 = (Int (111.0 * menuscale))
    For local0 = Each achievementmsg
        If (0.0 <> local0\Field3) Then
            If (((0.0 < local0\Field3) And (490.0 > local0\Field3)) <> 0) Then
                local0\Field3 = (local0\Field3 + fps\Field7[$01])
                If ((Float (- local2)) < local0\Field2) Then
                    local0\Field2 = max((local0\Field2 - (fps\Field7[$01] * 4.0)), (Float (- local2)))
                EndIf
            ElseIf (490.0 <= local0\Field3) Then
                local0\Field3 = -1.0
            ElseIf (-1.0 = local0\Field3) Then
                If (0.0 > local0\Field2) Then
                    local0\Field2 = min((local0\Field2 + (fps\Field7[$01] * 4.0)), 0.0)
                Else
                    local0\Field3 = 0.0
                EndIf
            EndIf
        Else
            Delete local0
        EndIf
    Next
    Return $00
End Function
