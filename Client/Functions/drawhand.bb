Function drawhand%(arg0%, arg1$, arg2%)
    Local local0#
    Local local1#
    Local local2#
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10#
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    If (menuopen = $00) Then
        If (((arg0 = $00) Or (arg2 = $00)) <> 0) Then
            Return $00
        EndIf
        cameraproject(camera, entityx(arg0, $00), entityy(arg0, $00), entityz(arg0, $00))
        local0 = projectedx()
        local1 = projectedy()
        local2 = projectedz()
        local3 = (imagewidth(arg2) Shr $01)
        local4 = (imageheight(arg2) Shr $01)
        local5 = imenuscale[$C8]
        local6 = (local3 + local5)
        local7 = (local4 + local5)
        local8 = ((graphicwidth - local3) - local5)
        local9 = ((graphicheight - local4) - local5)
        If (0.0 >= local2) Then
            local0 = ((Float viewport_center_x) - (local0 - (Float viewport_center_x)))
            local1 = ((Float viewport_center_y) - (local1 - (Float viewport_center_y)))
            local10 = max(((Abs (local0 - (Float viewport_center_x))) / (Float viewport_center_x)), ((Abs (local1 - (Float viewport_center_y))) / (Float viewport_center_y)))
            local0 = ((local0 - ((Float viewport_center_x) / local10)) + (Float viewport_center_x))
            local1 = ((local1 - ((Float viewport_center_y) / local10)) + (Float viewport_center_y))
        EndIf
        local0 = f_clamp(local0, (Float local6), (Float local8))
        local1 = f_clamp(local1, (Float local7), (Float local9))
        drawimage(arg2, (Int (local0 - (Float local3))), (Int (local1 - (Float local4))), $00)
        If (arg1 <> "") Then
            local1 = (local1 - ((Float local4) * 1.25))
            local11 = stringwidth(arg1)
            local12 = fonts[$00]\Field2
            local3 = (Int ((Float local11) * 0.5))
            local13 = imenuscale[$05]
            local14 = (Int ((local0 - (Float local3)) - (Float local13)))
            local15 = (Int ((local1 - (Float local12)) - (Float local13)))
            local13 = (local13 Shl $01)
            local16 = (local11 + local13)
            local17 = (local12 + local13)
            drawframe(local14, local15, local16, local17, $00, $00)
            setcolorraw($FFFFFF)
            setfontex(fonts[$00]\Field0)
            text((Int local0), (Int local1), arg1, $01, $02)
        EndIf
    EndIf
    Return $00
End Function
