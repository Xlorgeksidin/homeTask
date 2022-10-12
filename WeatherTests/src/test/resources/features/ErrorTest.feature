#language:ru
  
  Функционал: Проверка ошибок

    Сценарий: : Проверка ошибки bulk_queries_not_supported_on_plan
      Когда выполняем запрос к сервису weatherstack, методу "current" с параметрами "&query=London;Moscow" c валидным access_key
      Тогда получаем ошибку c типом "bulk_queries_not_supported_on_plan" и кодом 604

    Сценарий: : Проверка ошибки request_failed
      Когда выполняем запрос к сервису weatherstack, методу "current" с параметрами "&query=" c валидным access_key
      Тогда получаем ошибку c типом "missing_query" и кодом 601

    Сценарий: : Проверка ошибки missing_access_key
      Когда выполняем запрос к сервису weatherstack, методу "current" без access_key
      Тогда получаем ошибку c типом "missing_access_key" и кодом 101

    Сценарий: : Проверка ошибки invalid_api_function
      Когда выполняем запрос к сервису weatherstack, методу "currentttt" с параметрами "&query=London" c валидным access_key
      Тогда получаем ошибку c типом "invalid_api_function" и кодом 103
