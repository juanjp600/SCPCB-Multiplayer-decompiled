Function steam_api_setachievement%(arg0$)
    If (arg0 <> "") Then
        steam_achieve(arg0)
    EndIf
    Return $00
End Function
