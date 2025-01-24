Function mp_voicegetbitrate$(arg0%)
    If (((arg0 = $FFFFFC18) Lor (arg0 = $00)) <> 0) Then
        Return "Auto"
    EndIf
    Return (Str arg0)
    Return ""
End Function
