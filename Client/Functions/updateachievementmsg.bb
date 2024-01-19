Function updateachievementmsg%()
    Local local0.achievementmsg
    Local local1.achievementmsg
    Local local2#
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    local2 = ((Float graphicheight) / 768.0)
    local3 = (Int (264.0 * local2))
    local4 = (Int (84.0 * local2))
    For local0 = Each achievementmsg
        If (0.0 <> local0\Field3) Then
            local5 = (Int (local0\Field2 + (Float graphicwidth)))
            local6 = (graphicheight - local4)
            For local1 = Each achievementmsg
                If (local1 <> local0) Then
                    If (local1\Field4 > local0\Field4) Then
                        local6 = (local6 - local4)
                    EndIf
                EndIf
            Next
            drawframe(local5, local6, local3, local4, $00, $00)
            color($00, $00, $00)
            rect((Int ((10.0 * local2) + (Float local5))), (Int ((10.0 * local2) + (Float local6))), (Int (64.0 * local2)), (Int (64.0 * local2)), $01)
            drawimage(achvimg(local0\Field0), (Int ((10.0 * local2) + (Float local5))), (Int ((10.0 * local2) + (Float local6))), $00)
            color($32, $32, $32)
            rect((Int ((10.0 * local2) + (Float local5))), (Int ((10.0 * local2) + (Float local6))), (Int (64.0 * local2)), (Int (64.0 * local2)), $00)
            color($FF, $FF, $FF)
            aasetfont(font1)
            rowtext(("Achievement Unlocked - " + local0\Field1), ((84.0 * local2) + (Float local5)), ((10.0 * local2) + (Float local6)), ((Float local3) - (94.0 * local2)), ((Float local6) - (20.0 * local2)), $00, 1.0, $00)
            If (((0.0 < local0\Field3) And (490.0 > local0\Field3)) <> 0) Then
                local0\Field3 = (local0\Field3 + fpsfactor2)
                If ((Float (- local3)) < local0\Field2) Then
                    local0\Field2 = max((local0\Field2 - (4.0 * fpsfactor2)), (Float (- local3)))
                EndIf
            ElseIf (490.0 <= local0\Field3) Then
                local0\Field3 = -1.0
            ElseIf (-1.0 = local0\Field3) Then
                If (0.0 > local0\Field2) Then
                    local0\Field2 = min((local0\Field2 + (4.0 * fpsfactor2)), 0.0)
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
