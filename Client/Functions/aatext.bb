Function aatext%(arg0%, arg1%, arg2$, arg3%, arg4%, arg5#)
    Local local0.aafont
    Local local1.redirecttext
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    If (len(arg2) = $00) Then
        Return $00
    EndIf
    local0 = (Object.aafont aaselectedfont)
    If (disableredirectaccess = $00) Then
        For local1 = Each redirecttext
            If (instr(arg2, local1\Field1, $01) <> 0) Then
                arg2 = replace(arg2, local1\Field1, local1\Field2)
                Exit
            EndIf
        Next
    EndIf
    If ((((graphicsbuffer() <> backbuffer()) Or (aatextenable = $00)) Or (local0\Field12 = $00)) <> 0) Then
        setfont(local0\Field7)
        local2 = colorred()
        local3 = colorgreen()
        local4 = colorblue()
        color((Int ((Float local2) * arg5)), (Int ((Float local3) * arg5)), (Int ((Float local4) * arg5)))
        text(arg0, arg1, arg2, arg3, arg4)
        color(local2, local3, local4)
        Return $00
    EndIf
    If (arg3 <> 0) Then
        arg0 = (arg0 - (aastringwidth(arg2) Sar $01))
    EndIf
    If (arg4 <> 0) Then
        arg1 = (arg1 - (aastringheight(arg2) Sar $01))
    EndIf
    If (camera <> $00) Then
        hideentity(camera)
    EndIf
    If (ark_blur_cam <> $00) Then
        hideentity(ark_blur_cam)
    EndIf
    local5 = $00
    cameraprojmode(aatextcam, $02)
    local7 = $00
    For local8 = $01 To len(arg2) Step $01
        local6 = asc(mid(arg2, local8, $01))
        If (((local6 >= $00) And (local6 <= $FF)) <> 0) Then
            local7 = (local7 + local0\Field5[local6])
        EndIf
    Next
    aacamvieww = local7
    aacamvieww = (aacamvieww + (aacamvieww Mod $02))
    aacamviewh = aastringheight(arg2)
    aacamviewh = (aacamviewh + (aacamviewh Mod $02))
    local9 = arg0
    If (local9 < $00) Then
        local9 = $00
    EndIf
    local10 = arg1
    If (local10 < $00) Then
        local10 = $00
    EndIf
    local11 = ((arg0 - local9) + aacamvieww)
    If ((local11 + local9) > graphicwidth) Then
        local11 = (graphicwidth - local9)
    EndIf
    local12 = ((arg1 - local10) + aacamviewh)
    If ((local12 + local10) > graphicheight) Then
        local12 = (graphicheight - local10)
    EndIf
    local11 = (local11 - (local11 Mod $02))
    local12 = (local12 - (local12 Mod $02))
    aacamviewh = (aacamviewh + (aacamviewh Mod $02))
    aacamvieww = local11
    aacamviewh = local12
    cameraviewport(aatextcam, local9, local10, local11, local12)
    For local8 = $01 To len(arg2) Step $01
        entityalpha(aatextsprite[(local8 - $01)], arg5)
        entitycolor(aatextsprite[(local8 - $01)], (Float colorred()), (Float colorgreen()), (Float colorblue()))
        showentity(aatextsprite[(local8 - $01)])
        local6 = asc(mid(arg2, local8, $01))
        If (((local6 >= $00) And (local6 <= $FF)) <> 0) Then
            aaspritescale((local8 - $01), local0\Field5[local6], local0\Field6[local6])
            local13 = (local13 + local0\Field5[local6])
            local14 = local0\Field6[local6]
            aaspriteposition((local8 - $01), (((arg0 - local9) + local5) + (local0\Field5[local6] Sar $01)), ((arg1 - local10) + (local0\Field6[local6] Sar $01)))
            vertextexcoords(getsurface(aatextsprite[(local8 - $01)], $01), $00, ((Float local0\Field3[local6]) / 1024.0), ((Float local0\Field4[local6]) / 1024.0), 1.0, $00)
            vertextexcoords(getsurface(aatextsprite[(local8 - $01)], $01), $01, ((Float (local0\Field3[local6] + local0\Field5[local6])) / 1024.0), ((Float local0\Field4[local6]) / 1024.0), 1.0, $00)
            vertextexcoords(getsurface(aatextsprite[(local8 - $01)], $01), $02, ((Float local0\Field3[local6]) / 1024.0), ((Float (local0\Field4[local6] + local0\Field6[local6])) / 1024.0), 1.0, $00)
            vertextexcoords(getsurface(aatextsprite[(local8 - $01)], $01), $03, ((Float (local0\Field3[local6] + local0\Field5[local6])) / 1024.0), ((Float (local0\Field4[local6] + local0\Field6[local6])) / 1024.0), 1.0, $00)
            local5 = ((local0\Field5[local6] + local5) - $01)
        EndIf
    Next
    renderworld(1.0)
    cameraprojmode(aatextcam, $00)
    For local8 = $01 To len(arg2) Step $01
        hideentity(aatextsprite[(local8 - $01)])
    Next
    If (camera <> $00) Then
        showentity(camera)
    EndIf
    If (ark_blur_cam <> $00) Then
        showentity(ark_blur_cam)
    EndIf
    If (mouseon(arg0, arg1, local13, local14) <> 0) Then
        Return $01
    EndIf
    Return $00
    Return $00
End Function
