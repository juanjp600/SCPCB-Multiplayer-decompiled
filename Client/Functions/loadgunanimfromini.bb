Function loadgunanimfromini%(arg0.guns, arg1$)
    Local local0$
    Local local1%
    Local local2%
    Local local3%
    local0 = (("Data\Weapon_Animations\" + lower(arg1)) + ".ini")
    If (filesize(local0) = $00) Then
        createconsolemsg((((("WARNING: Couldn't load animation: " + chr($22)) + "Data\Weapon_Animations\") + lower(arg1)) + chr($22)), $FF, $00, $00, $00)
        Return $00
    EndIf
    local1 = getinisectionlocation(local0, "Animations")
    local2 = getiniint2(local0, local1, "Frame_Idle_Base", "-1")
    If (local2 <> $FFFFFFFF) Then
        addframetogun(arg0, $01, local2, $00)
    EndIf
    local2 = getiniint2(local0, local1, "Frame_Deploy_Start", "-1")
    local3 = getiniint2(local0, local1, "Frame_Deploy_End", "-1")
    If (((local2 <> $FFFFFFFF) And (local3 <> $FFFFFFFF)) <> 0) Then
        addframetogun(arg0, $04, local2, local3)
    EndIf
    local2 = getiniint2(local0, local1, "Frame_Deploy_Ready", "-1")
    If (local2 <> $FFFFFFFF) Then
        addframetogun(arg0, $05, local2, $00)
    EndIf
    local2 = getiniint2(local0, local1, "Frame_Reload_Start", "-1")
    local3 = getiniint2(local0, local1, "Frame_Reload_End", "-1")
    If (((local2 <> $FFFFFFFF) And (local3 <> $FFFFFFFF)) <> 0) Then
        addframetogun(arg0, $02, local2, local3)
    EndIf
    local2 = getiniint2(local0, local1, "Frame_Shoot_Start", "-1")
    local3 = getiniint2(local0, local1, "Frame_Shoot_End", "-1")
    If (((local2 <> $FFFFFFFF) And (local3 <> $FFFFFFFF)) <> 0) Then
        addframetogun(arg0, $03, local2, local3)
    EndIf
    Return $00
End Function
