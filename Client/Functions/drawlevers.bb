Function drawlevers%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local9%
    Local local10%
    If (menuopen = $00) Then
        If ((((drawarrowicon($00) Or drawarrowicon($01)) Or drawarrowicon($02)) Or drawarrowicon($03)) = $00) Then
            If (drawhandicon <> 0) Then
                drawblock(handicon, (viewport_center_x - (imagewidth(handicon) Shr $01)), (viewport_center_y - (imageheight(handicon) Shr $01)), $00)
            EndIf
            Return $00
        EndIf
        local0 = imagewidth(handicon)
        local1 = imageheight(handicon)
        local2 = (viewport_center_x - (local0 Shr $01))
        local3 = (viewport_center_y - (local1 Shr $01))
        local4 = $00
        local5 = $00
        local6 = $00
        For local7 = $00 To $03 Step $01
            If (drawarrowicon(local7) <> 0) Then
                Select local7
                    Case $00
                        local5 = (local5 - $40)
                        If (arg0 = $00) Then
                            local4 = $00
                        EndIf
                    Case $01
                        local4 = (local4 + $40)
                        If (arg0 <> 0) Then
                            local5 = $00
                        EndIf
                    Case $02
                        local5 = (- local5)
                        If (arg0 = $00) Then
                            local4 = $00
                        EndIf
                    Case $03
                        local4 = (- local4)
                        If (arg0 <> 0) Then
                            local5 = $00
                        EndIf
                End Select
                local6 = $01
                setcolorex($00, $00, $00)
                drawimage(handicon, (local2 + local4), (local3 + local5), $00)
                rect(((local2 + $04) + local4), ((local3 + $04) + local5), (local0 - $08), (local1 - $08), $01)
                local9 = imagewidth(arrowimg(local7))
                local10 = imageheight(arrowimg(local7))
                drawimage(arrowimg(local7), ((viewport_center_x - (local9 Shr $01)) + local4), ((viewport_center_y - (local10 Shr $01)) + local5), $00)
                drawarrowicon(local7) = $00
            EndIf
        Next
        If ((local6 Or drawhandicon) <> 0) Then
            drawimage(handicon, local2, local3, $00)
        EndIf
    EndIf
    Return $00
End Function
