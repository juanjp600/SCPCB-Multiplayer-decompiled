Function skynet_onload%(arg0%)
    If (arg0 = $00) Then
        script_count = (script_count + $01)
    Else
        workshop_script_count = (workshop_script_count + $01)
    EndIf
    Return $00
End Function
