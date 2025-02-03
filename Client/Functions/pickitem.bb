Function pickitem%(arg0.items, arg1%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    If ((((((menuopen Lor consoleopen) Lor i_294\Field0) Lor (d_i\Field6 <> Null)) Lor (selectedscreen <> Null)) Lor (Int me\Field0)) <> 0) Then
        Return $00
    EndIf
    catcherrors("PickItem()")
    local2 = $01
    local3 = $01
    For local0 = $00 To (maxitemamount - $01) Step $01
        If (inventory(local0) = Null) Then
            Select arg0\Field4\Field2
                Case $23
                    use1123()
                    If ((((i_714\Field0 <> $02) And (wi\Field0 <> $04)) And (wi\Field2 <> $04)) <> 0) Then
                        Return $00
                    EndIf
                Case $54
                    me\Field51 = 1.0
                    playsound_strict(snd_i\Field33[rand($00, $02)], $00, $01)
                    msg\Field2 = format(getlocalstring("death", "killbat"), subjectname, "%s")
                    kill($00, $01, $00, $01)
                Case $0C
                    giveachievement("148", $01)
                Case $5F
                    giveachievement("keycard6", $01)
                Case $60
                    giveachievement("omni", $01)
                Case $08,$09,$0A
                    giveachievement("005", $01)
                Case $2A
                    createmsg(getlocalstring("msg", "vfvest"), 6.0)
                    Return $00
                Case $29
                    createmsg(getlocalstring("msg", "corrvest"), 6.0)
                    Return $00
                Case $34,$36,$37,$35
                    arg0\Field12 = 0.0
                Case $4C
                    giveachievement("snav", $01)
                Case $27,$28
                    For local1 = $00 To (maxitemamount - $01) Step $01
                        If (inventory(local1) <> Null) Then
                            If (((inventory(local1)\Field4\Field2 = $27) Lor (inventory(local1)\Field4\Field2 = $28)) <> 0) Then
                                local3 = $00
                            ElseIf (((((inventory(local1)\Field4\Field2 = $3C) Lor (inventory(local1)\Field4\Field2 = $3D)) Lor (inventory(local1)\Field4\Field2 = $3E)) Lor (inventory(local1)\Field4\Field2 = $3F)) <> 0) Then
                                local3 = $02
                            EndIf
                        EndIf
                    Next
                    If (local3 = $00) Then
                        createmsg(getlocalstring("msg", "twovest"), 6.0)
                        Return $00
                    ElseIf (local3 = $02) Then
                        createmsg(getlocalstring("msg", "vestsuit"), 6.0)
                        Return $00
                    Else
                        selecteditem = arg0
                    EndIf
                Case $3C,$3D,$3E,$3F
                    For local1 = $00 To (maxitemamount - $01) Step $01
                        If (inventory(local1) <> Null) Then
                            If (((((inventory(local1)\Field4\Field2 = $3C) Lor (inventory(local1)\Field4\Field2 = $3D)) Lor (inventory(local1)\Field4\Field2 = $3E)) Lor (inventory(local1)\Field4\Field2 = $3F)) <> 0) Then
                                local3 = $00
                            ElseIf (((inventory(local1)\Field4\Field2 = $27) Lor (inventory(local1)\Field4\Field2 = $28)) <> 0) Then
                                local3 = $02
                            EndIf
                        EndIf
                    Next
                    If (local3 = $00) Then
                        createmsg(getlocalstring("msg", "twosuit"), 6.0)
                        Return $00
                    ElseIf (local3 = $02) Then
                        createmsg(getlocalstring("msg", "vestsuit"), 6.0)
                        Return $00
                    Else
                        selecteditem = arg0
                    EndIf
            End Select
            If (((arg0\Field4\Field3 <> $42) And arg1) <> 0) Then
                playsound_strict(snd_i\Field44[arg0\Field4\Field3], $00, $01)
            EndIf
            arg0\Field15 = $01
            arg0\Field16 = $FFFFFFFF
            arg0\Field4\Field4 = $01
            If (arg0\Field20 > $00) Then
                For local1 = $00 To (arg0\Field20 - $01) Step $01
                    If (arg0\Field18[local1] <> Null) Then
                        arg0\Field18[local1]\Field4\Field4 = $01
                    EndIf
                Next
            EndIf
            inventory(local0) = arg0
            hideentity(arg0\Field2)
            mp_pickitem(arg0)
            me\Field42 = max(2.0, me\Field42)
            local2 = $00
            Exit
        EndIf
    Next
    If (local2 <> 0) Then
        createmsg(getlocalstring("msg", "cantcarry"), 6.0)
    EndIf
    catcherrors("Uncaught: PickItem()")
    Return $00
    Return $00
End Function
