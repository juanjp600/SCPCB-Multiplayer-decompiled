Function voice_isrecording%()
    Return ((((keydown(key_voice) And (networkserver\Field19 = $00)) And (consoleopen = $00)) And (menuopen = $00)) Or networkserver\Field18)
    Return $00
End Function
