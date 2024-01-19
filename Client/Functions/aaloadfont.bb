Function aaloadfont%(arg0$, arg1#, arg2%, arg3%, arg4%, arg5%)
    Local local0.redirectfont
    Local local1.aafont
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
    Local local15#
    Local local16#
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    Local local22%
    Local local23%
    Local local24%
    Local local25%
    For local0 = Each redirectfont
        If (local0\Field0 = lower(arg0)) Then
            arg0 = local0\Field1
        EndIf
    Next
    local1 = (New aafont)
    local1\Field7 = loadfont(arg0, (Int arg1), arg2, arg3, arg4)
    local1\Field0 = arg0
    local1\Field8 = arg1
    setfont(local1\Field7)
    local1\Field9 = fontwidth()
    local1\Field10 = fontheight()
    If ((aatextenable And (arg5 > $01)) <> 0) Then
        local2 = loadfont(arg0, (Int (arg1 * (Float arg5))), arg2, arg3, arg4)
        local3 = createtexture($400, $400, $03, $01)
        local4 = $00
        local5 = $01
        setfont(local2)
        local6 = createimage((fontwidth() + (arg5 Shl $01)), (fontheight() + (arg5 Shl $01)), $01)
        clscolor($00, $00, $00)
        lockbuffer(texturebuffer(local3, $00))
        local7 = (local1\Field10 * (((local1\Field9 * $5F) Sar $0A) + $02))
        debuglog((Str local7))
        local1\Field9 = $00
        For local8 = $00 To $3FF Step $01
            For local9 = $00 To local7 Step $01
                writepixelfast(local8, local9, $FFFFFF, texturebuffer(local3, $00))
            Next
        Next
        For local10 = $01 To $FF Step $01
            setbuffer(imagebuffer(local6, $00))
            cls()
            color($FF, $FF, $FF)
            setfont(local2)
            text((arg5 Sar $01), (arg5 Sar $01), chr(local10), $00, $00)
            local11 = stringwidth(chr(local10))
            local12 = fontheight()
            setfont(local1\Field7)
            local13 = stringwidth(chr(local10))
            local14 = fontheight()
            local15 = ((Float local11) / (Float local13))
            local16 = ((Float local12) / (Float local14))
            setbuffer(backbuffer())
            lockbuffer(imagebuffer(local6, $00))
            For local9 = $00 To (local14 - $01) Step $01
                For local8 = $00 To (local13 - $01) Step $01
                    local17 = (Int (((Float local8) * local15) - (local15 * 0.0)))
                    If (local17 < $00) Then
                        local17 = $00
                    EndIf
                    local18 = (Int (((Float local9) * local16) - (local16 * 0.0)))
                    If (local18 < $00) Then
                        local18 = $00
                    EndIf
                    local19 = (Int (((Float local8) * local15) + (local15 * 1.0)))
                    If (local19 > local11) Then
                        local19 = (local11 - $01)
                    EndIf
                    local20 = (Int (((Float local9) * local16) + (local16 * 1.0)))
                    If (local20 > local12) Then
                        local20 = (local12 - $01)
                    EndIf
                    local21 = $00
                    If (((Abs (local17 - local19)) * (Abs (local18 - local20))) > $00) Then
                        For local22 = local18 To (local20 - $01) Step $01
                            For local23 = local17 To (local19 - $01) Step $01
                                local21 = (local21 + (readpixelfast(local23, local22, imagebuffer(local6, $00)) And $FF))
                            Next
                        Next
                        local21 = (local21 / ((Abs (local17 - local19)) * (Abs (local18 - local20))))
                        If (local21 > $FF) Then
                            local21 = $FF
                        EndIf
                        local21 = (Int ((((Float local21) / 255.0) ^ 0.5) * 255.0))
                    EndIf
                    writepixelfast((local8 + local4), (local9 + local5), ((local21 Shl $18) + $FFFFFF), texturebuffer(local3, $00))
                Next
            Next
            unlockbuffer(imagebuffer(local6, $00))
            local1\Field3[local10] = local4
            local1\Field4[local10] = local5
            local1\Field5[local10] = local13
            If (local1\Field9 < (local1\Field5[local10] - $03)) Then
                local1\Field9 = (local1\Field5[local10] - $03)
            EndIf
            local1\Field6[local10] = local14
            local4 = ((local1\Field5[local10] + local4) + $02)
            If (local4 > (($400 - fontwidth()) - $04)) Then
                local4 = $00
                local5 = ((fontheight() + local5) + $06)
            EndIf
        Next
        local1\Field11 = local7
        local24 = createimage($400, $400, $01)
        lockbuffer(imagebuffer(local24, $00))
        For local8 = $00 To $3FF Step $01
            For local9 = $00 To local1\Field11 Step $01
                local25 = (readpixelfast(local8, local9, texturebuffer(local3, $00)) Shr $18)
                local25 = (((local25 Shl $08) + local25) + (local25 Shl $10))
                writepixelfast(local8, local9, ($FF000000 + local25), imagebuffer(local24, $00))
            Next
        Next
        unlockbuffer(imagebuffer(local24, $00))
        local1\Field2 = local24
        unlockbuffer(texturebuffer(local3, $00))
        freeimage(local6)
        freefont(local2)
        local1\Field1 = local3
        local1\Field12 = $01
    Else
        local1\Field12 = $00
    EndIf
    Return (Handle local1)
    Return $00
End Function
